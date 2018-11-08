package com.neosoft.demospofity.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.demospofity.entity.bean.AlbumBean;
import com.neosoft.demospofity.service.LibraryService;
import com.neosoft.demospofity.service.SearchService;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(value="/demospotify/")
public class DemoSpotifyController {

	@Autowired
	private SearchService searchService;
	
	@Autowired
	private LibraryService libraryService;
	
    @RequestMapping({"/"})
    public String index() {
        return "index";
    }
	
	@GetMapping(value="/search/{criteria}")
	@ResponseBody
	public List<AlbumBean> search(@PathVariable("criteria") String criteria){
		List<AlbumBean> result = searchService.searchAlbums(criteria);
		
		return result;
	}

}