package com.example.demo.Dao;

import com.example.demo.entities.Brands;

import java.util.List;

/**
 * Created by ahmed on 1/31/2018.
 */
public interface BrandDao {
    public Brands saveBrands(Brands brands);

    public Brands updateBrands(int id, Brands brands);

    public int deleteBrandsById(int id);

    public Brands getBrandsById(int id);
    public List<Brands> getAll();
}
