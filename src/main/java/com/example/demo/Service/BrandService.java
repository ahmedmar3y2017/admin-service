package com.example.demo.Service;

import com.example.demo.entities.Brands;

import java.util.List;

/**
 * Created by ahmed on 1/31/2018.
 */
public interface BrandService {
    public Brands saveBrands(Brands brands);

    public Brands updateBrands(Brands brands);

    public int deleteBrandsById(int id);

    public Brands getBrandsById(int id);

    public List<Brands> getAll();

    int deleteBrandsByAvailable(int id);
}
