package com.zyf.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.zyf.dao.BookDao;
import com.zyf.entity.Book;

@Controller
@RequestMapping("/book")
public class BookController {
	@Resource
	private BookDao bookDao;
	
	@RequestMapping("/list")
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("books", bookDao.findAll());
		modelAndView.setViewName("bookList");
		return modelAndView;
	}
	
	/**
	 * 根据id查询book实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/preUpdate/{id}")
	public ModelAndView preUpdate(@PathVariable("id")Integer id){
		ModelAndView mav=new ModelAndView();
		mav.addObject("book", bookDao.getOne(id));
		mav.setViewName("bookUpdate");
		return mav;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Book book){
		bookDao.save(book);
		return "forward:/book/list";
	}
	//post方式
	@PostMapping(value="/update")//可以省略value
	public String update(Book book){
		bookDao.save(book);
		return "forward:/book/list";
	}
	//get方式
	@GetMapping("/delete")//可以省略value
	public String delete(Integer id){
		bookDao.delete(id);
		return "forward:/book/list";
	}
	
	@RequestMapping("/deleteRestful/{id}")
	public String deleteRestful(@PathVariable("id")Integer id){
		bookDao.delete(id);
		return "forward:/book/list";
	}
	
	@ResponseBody
	@GetMapping("/queryByName")
	public List<Book> queryByName(){
		return bookDao.findByName("j");
	}
	
	@ResponseBody
	@GetMapping("/randomList")
	public List<Book> randomList(){
		return bookDao.randomList(2);
	}
	
	
	/**
	 * 根据条件动态查询
	 * @param book
	 * @return
	 */
	@RequestMapping("/list2")
	public ModelAndView list2( final Book book){
		ModelAndView modelAndView=new ModelAndView();
		List<Book> bookList=bookDao.findAll(new Specification<Book>(){

			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(book!=null){
					if(book.getName()!=null && !"".equals(book.getName())){
						predicate.getExpressions().add(cb.like(root.get("name").as(String.class), "%"+book.getName()+"%"));
					}
					if(book.getAuthor()!=null && !"".equals(book.getAuthor())){
						predicate.getExpressions().add(cb.like(root.get("author").as(String.class), "%"+book.getAuthor()+"%"));
					}
				}
				return predicate;
			}
			
		});
		modelAndView.addObject("books", bookList);
		modelAndView.setViewName("bookList");
		return modelAndView;
	}
	
}

