package com.zyf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.zyf.entity.Book;
									//book实体类对应表主键是整型这里就写整型
public interface BookDao extends JpaRepository<Book, Integer>,JpaSpecificationExecutor<Book>{

	//query注解 自定义查询(HQL语句)                      1表示第一个参数
	@Query("select b from Book b where b.name like %?1%")
	public List<Book> findByName(String name);
	
	
	//query注解 自定义查询(sql语句)  随机查出n条数据 							开启本地查询true（默认是不开启false）
	@Query(value="select * from t_book order by RAND() limit ?1",nativeQuery=true)
	public List<Book> randomList(Integer n);
}
