package com.project.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.AirhostessDao;
import com.project.flight_management_system.dto.Airhostess;
import com.project.flight_management_system.exception.AirhostessIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

@Service
public class AirhostessService {

	@Autowired
	AirhostessDao airhostessDao;

	@Autowired
	ResponseStructure<Airhostess> responseStructure;

	@Autowired
	ResponseStructureAll<Airhostess> responseStructureAll;

	public ResponseStructure<Airhostess> saveAirhostess(Airhostess airhostess) {
		responseStructure.setMessage("Successfully Airhostess Saved in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(airhostessDao.saveAirhostess(airhostess));
		return responseStructure;
	}

	public ResponseStructure<Airhostess> fetchAirhostessById(int airhostessId) {
		Airhostess airhostess = airhostessDao.fetchAirhostessById(airhostessId);
		if (airhostess != null) {
			responseStructure.setMessage("Successfully  Fetched Airhostess From DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(airhostessDao.fetchAirhostessById(airhostessId));
			return responseStructure;
		} else {
			throw new AirhostessIdNotFound();
		}
	}

	public ResponseStructure<Airhostess> deleteAirhostessById(int airhostessId) {
		Airhostess airhostess = airhostessDao.fetchAirhostessById(airhostessId);
		if (airhostess != null) {
			responseStructure.setMessage("Successfully  Deleted Airhostess From DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airhostessDao.deleteAirhostessById(airhostessId));
			return responseStructure;
		} else {
			throw new AirhostessIdNotFound();
		}
	}

	public ResponseStructure<Airhostess> updateAirhostessById(int oldAirhostessId, Airhostess newAirhostess) {
		Airhostess airhostess = airhostessDao.fetchAirhostessById(oldAirhostessId);
		if (airhostess != null) {
			responseStructure.setMessage("Successfully  Updated Airhostess In DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airhostessDao.updateAirhostessById(oldAirhostessId, newAirhostess));
			return responseStructure;
		} else {
			throw new AirhostessIdNotFound();
		}
	}

	public ResponseStructureAll<Airhostess> fetchAllAirhostess() {
		responseStructureAll.setMessage("Successfully All Airhostess Fetched From DB");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(airhostessDao.fetchAllAirhostess());
		return responseStructureAll;
	}

}
