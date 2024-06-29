package com.odoo.combat.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.odoo.combat.config.general.ImageKitConf;
import com.odoo.combat.services.StorageService;

import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.exceptions.BadRequestException;
import io.imagekit.sdk.exceptions.ForbiddenException;
import io.imagekit.sdk.exceptions.InternalServerException;
import io.imagekit.sdk.exceptions.TooManyRequestsException;
import io.imagekit.sdk.exceptions.UnauthorizedException;
import io.imagekit.sdk.exceptions.UnknownException;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.results.Result;

@Service
public class StorageServiceImpl implements StorageService {

	private ImageKit imageKit = ImageKitConf.getImageKitConf();

	@Override
	public String upload(MultipartFile file, String name, String FOLDER_NAME) throws IOException {

		try {
			FileCreateRequest request = new FileCreateRequest(file.getBytes(), name);
			request.folder = FOLDER_NAME;
			Result response = imageKit.upload(request);
			return response.getUrl();
		} catch (InternalServerException | BadRequestException | UnknownException | ForbiddenException
				| TooManyRequestsException | UnauthorizedException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public String upload(MultipartFile file, String name, String FOLDER_NAME, Long ImageId) throws IOException {
		try {
			FileCreateRequest request = new FileCreateRequest(file.getBytes(), name);
			request.folder = FOLDER_NAME;
			Result response = imageKit.upload(request);
			return response.getUrl();
		} catch (InternalServerException | BadRequestException | UnknownException | ForbiddenException
				| TooManyRequestsException | UnauthorizedException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<String> upload(MultipartFile[] images, String name, String FOLDER_NAME) throws IOException {
		try {
			List<String> imagesList = new ArrayList<>();
			for (MultipartFile file : images) {
				FileCreateRequest request = new FileCreateRequest(file.getBytes(), name);
				request.folder = FOLDER_NAME;
				Result response = imageKit.upload(request);
				imagesList.add(response.getUrl());
			}
			return imagesList;
		} catch (InternalServerException | BadRequestException | UnknownException | ForbiddenException
				| TooManyRequestsException | UnauthorizedException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getImageUrl(String fileId) {
		try {
			return imageKit.getFileDetail(fileId).getUrl();
		} catch (ForbiddenException | TooManyRequestsException | InternalServerException | UnauthorizedException
				| BadRequestException | UnknownException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
