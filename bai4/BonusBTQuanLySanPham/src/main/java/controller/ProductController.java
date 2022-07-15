package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.CatergoryService;
import service.ProductService;
import service.IProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model) {

        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("catergoryList", CatergoryService.catergoryList);
        return "/create";
    }

    @PostMapping("/save")
    public String save(@RequestParam int idC, Product product, RedirectAttributes redirect) {
        for (int i = 0; i < CatergoryService.catergoryList.size(); i++) {
            if(CatergoryService.catergoryList.get(i).getIdC() == idC) {
                product.setCatergory(CatergoryService.catergoryList.get(i));
            }
        }
        productService.save(product);
        redirect.addFlashAttribute("success","Saved product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("catergoryList", CatergoryService.catergoryList);
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@RequestParam int idC, Product product) {
        for (int i = 0; i < CatergoryService.catergoryList.size(); i++) {
            if(CatergoryService.catergoryList.get(i).getIdC() == idC) {
                product.setCatergory(CatergoryService.catergoryList.get(i));
            }
        }
        productService.update(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int idC, Product product, RedirectAttributes redirect) {
        for (int i = 0; i < CatergoryService.catergoryList.size(); i++) {
            if(CatergoryService.catergoryList.get(i).getIdC() == idC) {
                product.setCatergory(CatergoryService.catergoryList.get(i));
            }
        }
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }

    @PostMapping("/search")
    public String search(@RequestParam String name,Model model) {
        List<Product> productList = productService.findByName(name);
        model.addAttribute("products", productList);
        return "/search";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }
}
