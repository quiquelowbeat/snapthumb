package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.BackgroundNotFound;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.DomainUploadedBackgroundFinder;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.uploaded_background.UploadedBackgroundRepository;

import io.vavr.control.Either;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class UploadedBackgroundFinder {

    private final DomainUploadedBackgroundFinder finder;

    public UploadedBackgroundFinder(UploadedBackgroundRepository repository) {
        this.finder = new DomainUploadedBackgroundFinder(repository);
    }

    public Either<BackgroundNotFound, UploadedBackground> find(String uuid) {
        return finder.find(uuid);
    }

}
