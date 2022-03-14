package org.generation.SpringAssessment.controller;


import org.generation.SpringAssessment.controller.dto.ItemDTO;
import org.generation.SpringAssessment.repository.entity.Item;
import org.generation.SpringAssessment.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;



import java.util.Date;

@RestController
@RequestMapping("/item")

public class ItemController {

    final ItemService itemService;

    //constructor
    public ItemController(@Autowired ItemService itemService) {
        this.itemService = itemService;
    }

    @CrossOrigin
    @GetMapping("/all")

    public Iterable<Item> getItems() {
        return itemService.all();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Item findItemById(@PathVariable Integer id) {
        return itemService.findById(id);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        itemService.delete(id);
    }

    @CrossOrigin
    @PostMapping("/add")

    public void save(@RequestParam(name = "title", required = true) String title,
                     @RequestParam(name = "description", required = true) String description,
                     @RequestParam(name = "targetDate", required = true) Date targetDate)


    {
        ItemDTO itemDTO = new ItemDTO(title, description, targetDate);
        itemService.save(new Item(itemDTO));
    }


}