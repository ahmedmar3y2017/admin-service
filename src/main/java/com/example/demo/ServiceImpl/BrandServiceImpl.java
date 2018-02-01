package com.example.demo.ServiceImpl;

import com.example.demo.DaoImpl.BrandDaoImpl;
import com.example.demo.Service.BrandService;
import com.example.demo.entities.Brands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ahmed on 1/31/2018.
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandDaoImpl brandDao;

    @Override
    public Brands saveBrands(Brands brands) {
        return brandDao.saveBrands(brands);
    }

    @Override
    public Brands updateBrands(int id, Brands brands) {
        return brandDao.updateBrands(id, brands);
    }

    @Override
    public int deleteBrandsById(int id) {
        return brandDao.deleteBrandsById(id);
    }

    @Override
    public Brands getBrandsById(int id) {
        return brandDao.getBrandsById(id);
    }

    @Override
    public List<Brands> getAll() {
        return brandDao.getAll();
    }
}
