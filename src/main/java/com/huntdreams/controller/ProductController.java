package com.huntdreams.controller;

import com.huntdreams.domain.Product;
import com.huntdreams.exception.NoProductsFoundUnderCategoryException;
import com.huntdreams.exception.ProductNotFoundException;
import com.huntdreams.service.ProductService;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * Created by noprom on 1/22/16.
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 新增商品的时候过滤不需要绑定的字段
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("unitsInOrder", "discontinued");
        binder.setAllowedFields("productId", "name", "unitPrice", "description",
                "manufacturer", "category", "unitInStock", "productImage");
    }

    /**
     * 商品列表
     * @param model
     * @return
     */
    @RequestMapping
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    /**
     * 所有商品
     * @param model
     * @return
     */
    @RequestMapping("/all")
    public String allProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    /**
     * 某一分类下的商品
     * @param model
     * @param productCategory
     * @return
     */
    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
        List<Product> products = productService.getProductsByCategory(productCategory);
        if (products == null || products.isEmpty()) {
            throw new NoProductsFoundUnderCategoryException();
        }
        model.addAttribute("products", products);
        return "products";
    }

    /**
     * 根据分类查找商品
     * @param filterParams
     * @param model
     * @return
     */
    @RequestMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria")Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }

    /**
     * 商品详情
     * @param productId
     * @param model
     * @return
     */
    @RequestMapping("product")
    public String getProductById(@RequestParam("id") String productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    /**
     * 根据分类和价格查找商品
     * @param category
     * @param filterParams
     * @param manufacture
     * @param model
     * @return
     */
    @RequestMapping("/{category}/{price}")
    public String filterProducts(
            @PathVariable("category") String category,
            @MatrixVariable(pathVar = "price") Map<String, List<String>> filterParams,
            @RequestParam("manufacture") String manufacture,
            Model model) {
        model.addAttribute("product", productService.filterProducts(category, manufacture, filterParams));
        return "products";
    }

    /**
     * 新增商品
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model) {
        Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }

    /**
     * 新增商品提交页面
     * @param newProduct
     * @param result
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct,
                                           BindingResult result, HttpServletRequest request) {
        // 过滤不允许提交的字段
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attemping to bind disabled fields : " +
                    StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }

        // 上传图片
        MultipartFile productImage = newProduct.getProductImage();
        String rootDir = request.getSession().getServletContext().getRealPath("/");
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(rootDir + "/WEB-INF/static/images/" + newProduct.getProductId() + ".png"));
            } catch (IOException e) {
                throw new RuntimeException("Product Image saving failed!", e);
            }
        }
        productService.addProduct(newProduct);
        return "redirect:/products";
    }

    /**
     * 未找到商品错误页面提示
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleError(HttpServletRequest request, ProductNotFoundException exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("invalidProductId", exception.getProductId());
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("url", request.getRequestURL() + "?" + request.getQueryString());
        modelAndView.setViewName("productNotFound");
        return modelAndView;
    }
}
