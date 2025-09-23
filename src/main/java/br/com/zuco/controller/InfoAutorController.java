package br.com.zuco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zuco.entity.InfoAutor;
import br.com.zuco.service.InfoAutorService;

@RestController
@RequestMapping("info")
public class InfoAutorController {

	@Autowired
	private InfoAutorService infoAutorService;
	
	@GetMapping("{id}")
	public InfoAutor buscarPorId(@PathVariable Long id) {
		return infoAutorService.buscarPorId(id);
	}
	
	@GetMapping("cargo/{cargo}")
    public List<InfoAutor> buscarTodosContemCargo(@PathVariable String cargo) {
        return infoAutorService.buscarTodosContemCargo(cargo);
    }

    @GetMapping("cargo/{cargo}/empresa/{empresa}")
    public List<InfoAutor> buscarTodosCargoEhEmpresa(@PathVariable String cargo, @PathVariable String empresa) {
        return infoAutorService.buscarTodosCargoEhEmpresa(cargo, empresa);
    }

    @GetMapping("bio/{bio}")
    public InfoAutor buscarPorBio(@PathVariable String bio) {
        return infoAutorService.buscarPorBio(bio);
    }
    
}
