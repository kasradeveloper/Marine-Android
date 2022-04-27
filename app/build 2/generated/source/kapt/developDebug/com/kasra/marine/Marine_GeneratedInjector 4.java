package com.kasra.marine;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = Marine.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface Marine_GeneratedInjector {
  void injectMarine(Marine marine);
}
