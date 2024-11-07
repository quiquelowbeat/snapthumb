package com.snapthumb.thumbnailgenerator.image_creation.background.application;

import org.springframework.stereotype.Service;

import com.snapthumb.thumbnailgenerator.image_creation.background.domain.DomainUploadedBackgroundFinder;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackground;
import com.snapthumb.thumbnailgenerator.image_creation.background.domain.UploadedBackgroundRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UploadedBackgroundFinder {

    private final DomainUploadedBackgroundFinder finder;

    public UploadedBackgroundFinder(UploadedBackgroundRepository repository) {
        this.finder = new DomainUploadedBackgroundFinder(repository);
    }

    public UploadedBackground find(String uuid) {
        return finder.find(uuid);
    }

}
