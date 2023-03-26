package com.example.picture_management1.service.impl;

import com.example.picture_management1.model.Picture;
import com.example.picture_management1.service.ICoreService;

import java.util.ArrayList;
import java.util.List;

public class PictureServiceImpl implements ICoreService<Picture> {
    private final List<Picture> pictures;

    public PictureServiceImpl() {
        pictures = new ArrayList<>();
        pictures.add(new Picture("A324", 100d, 50d, "canvas", 150d, "beautiful"));
        pictures.add(new Picture("G423", 300d, 120d, "canvas", 400d, "vip"));
        pictures.add(new Picture("G63", 250d, 100d, "canvas", 150d, "super vip"));
    }

    @Override
    public void save(Picture picture) {
        if (picture.getId() == null) {
            picture.setId(pictures.get(pictures.size() - 1).getId() + 1);
            pictures.add(picture);
        } else {
            Picture pictureUpdate = findById(picture.getId());
            if (pictureUpdate != null) {
                pictureUpdate.setPictureCode(picture.getPictureCode());
                pictureUpdate.setLength(picture.getLength());
                pictureUpdate.setWidth(picture.getWidth());
                pictureUpdate.setMaterial(picture.getMaterial());
                pictureUpdate.setPrice(picture.getPrice());
                pictureUpdate.setDescription(picture.getDescription());
            }
        }
    }

    @Override
    public void delete(Long id) {
        Picture picture = findById(id);
        if (picture != null) {
            pictures.remove(picture);
        }
    }

    @Override
    public List<Picture> findAll() {
        return pictures;
    }

    @Override
    public Picture findById(Long id) {
        for (Picture e : pictures) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }
}

