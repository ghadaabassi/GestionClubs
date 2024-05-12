package com.fullstack.tpspring.Controllers;

import com.fullstack.tpspring.entities.Club;
import com.fullstack.tpspring.service.IGestionClub;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Clubs")
@AllArgsConstructor
public class ClubController {
    IGestionClub iGestionClub;

    @PostMapping("/add")
    public Club addClub(@RequestBody Club Club) {
        return iGestionClub.addClub(Club);
    }

    @GetMapping("get/{id}")
    public Club getById(@PathVariable int id) {
        return iGestionClub.getClubById(id);
    }

    @PutMapping("/update/{id}")
    public Club updateClub(@PathVariable int id, @RequestBody Club Club) {
        Club.setId(id);
        return iGestionClub.updateClub(Club);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClub(@PathVariable int id) {
        iGestionClub.deleteClub(id);
    }

}
