package com.admin.service;


import com.admin.model.Quection;

import java.util.List;

public interface QuectionService {

  Quection save(Quection e);

  Quection findById(int id);

  String deleteQ(int id);

  List<Quection> fethAllQuections();
}
