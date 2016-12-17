package com.liusiyang.question.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.liusiyang.question.dao.BaseMapper;
import com.liusiyang.question.dao.BasketListMapper;
import com.liusiyang.question.dao.BasketTempMapper;
import com.liusiyang.question.dao.ChapterQuestionMapper;
import com.liusiyang.question.dao.EmphasisQuestionMapper;
import com.liusiyang.question.dao.QuestionContentMapper;
import com.liusiyang.question.entity.Page;
import com.liusiyang.question.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {
	protected BaseMapper<T> baseMapper;

	@Autowired
	protected QuestionContentMapper questionContentMapper;

	@Autowired
	protected ChapterQuestionMapper chapterQuestionMapper;

	@Autowired
	protected EmphasisQuestionMapper emphasisQuestionMapper;

	@Autowired
	protected BasketListMapper basketListMapper;

	@Autowired
	protected BasketTempMapper basketTempMapper;

	@PostConstruct
	// 在构造方法后，初化前执行
	private void initBaseMapper() throws Exception {
		// 完成以下逻辑，需要对研发本身进行命名与使用规范
		// this关键字指对象本身，这里指的是调用此方法的实现类（子类）
		System.out.println("=======this :" + this);
		System.out.println("=======父类基本信息：" + this.getClass().getSuperclass());
		System.out.println("=======父类和泛型的信息："
				+ this.getClass().getGenericSuperclass());

		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		// 获取第一个参数的class
		Class clazz = (Class) type.getActualTypeArguments()[0];
		System.out.println("=======class:" + clazz);
		// 转化为属性名（相关的Mapper子类的引用名）Supplier supplierMapper
		String localField = clazz.getSimpleName().substring(0, 1).toLowerCase()
				+ clazz.getSimpleName().substring(1) + "Mapper";
		System.out.println("=======localField:" + localField);
		// getDeclaredField:可以使用于包括私有、默认、受保护、公共字段，但不包括继承的字段
		Field field = this.getClass().getSuperclass()
				.getDeclaredField(localField);
		System.out.println("=======field:" + field);
		System.out.println("=======field对应的对象:" + field.get(this));
		Field baseField = this.getClass().getSuperclass()
				.getDeclaredField("baseMapper");

		System.out.println("=======baseField:" + baseField);
		System.out.println("=======baseField对应的对象:" + baseField.get(this));
		// field.get(this)获取当前this的field字段的值。例如：Supplier对象中，baseMapper所指向的对象为其子类型SupplierMapper对象，子类型对象已被spring实例化于容器中
		baseField.set(this, field.get(this));
		System.out.println("========baseField对应的对象:" + baseMapper);

	}

	public int insert(T entity) throws Exception {
		return baseMapper.insert(entity);
	}

	public int update(T entity) throws Exception {
		return baseMapper.update(entity);
	}

	public int delete(Integer id) throws Exception {
		return baseMapper.delete(id);
	}

	public int deleteList(String[] pks) throws Exception {
		return baseMapper.deleteList(pks);
	}

	public T select(Integer id) throws Exception {
		return baseMapper.select(id);
	}

	public Page<T> selectPage(Page<T> page) throws Exception {
		page.setList(baseMapper.selectPageList(page));
		page.setTotalRecord(baseMapper.selectPageCount(page));
		return page;
	}

	public Page<T> selectPageUseDyc(Page<T> page) throws Exception {
		page.setList(baseMapper.selectPageListUseDyc(page));
		page.setTotalRecord(baseMapper.selectPageCountUseDyc(page));
		return page;
	}
	

	public List<T> getAll() throws Exception {
		return baseMapper.selectAll();
	}


}
