package net.golovach.eshop.dao;

import net.golovach.eshop.dao.exception.DaoSystemException;
import net.golovach.eshop.dao.exception.NoSuchEntityException;
import net.golovach.eshop.entity.Product;

import java.util.List;

public interface ProductDao {
    Product selectById(int id) throws DaoSystemException, NoSuchEntityException;
    List<Product> selectAll() throws DaoSystemException;
}
