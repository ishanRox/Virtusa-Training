package com.ishan.app.service;

import com.ishan.app.model.Quection;

public interface QuectionService {


	Quection[] fetchQuections(String subject,String title);
}
