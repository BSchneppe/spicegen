package com.oviva.spicegen.api;

import com.oviva.spicegen.api.internal.LookupResourcesImpl;

public interface LookupResources<T extends ObjectRef> {

  String permission();

  SubjectRef subject();

  ObjectRefFactory<T> resourceType();

  static <T extends ObjectRef> Builder<T> newBuilder() {
    return LookupResourcesImpl.newBuilder();
  }

  interface Builder<T extends ObjectRef> {
    Builder<T> permission(String permission);

    Builder<T> subject(SubjectRef subject);

    Builder<T> resourceType(ObjectRefFactory<T> resourceType);

    LookupResources<T> build();
  }
}
