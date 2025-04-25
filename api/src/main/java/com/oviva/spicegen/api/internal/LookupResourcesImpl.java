package com.oviva.spicegen.api.internal;

import com.oviva.spicegen.api.LookupResources;
import com.oviva.spicegen.api.LookupResources.Builder;
import com.oviva.spicegen.api.ObjectRef;
import com.oviva.spicegen.api.ObjectRefFactory;
import com.oviva.spicegen.api.SubjectRef;

public record LookupResourcesImpl<T extends ObjectRef>(
    String permission, SubjectRef subject, ObjectRefFactory<T> resourceType)
    implements LookupResources<T> {

  private LookupResourcesImpl(Builder<T> builder) {
    this(builder.permission, builder.subject, builder.resourceType);
  }

  public static <T extends ObjectRef> Builder<T> newBuilder() {
    return new Builder<>();
  }

  public static final class Builder<T extends ObjectRef> implements LookupResources.Builder<T> {
    private String permission;
    private SubjectRef subject;
    private ObjectRefFactory<T> resourceType;

    @Override
    public Builder<T> permission(String permission) {
      this.permission = permission;
      return this;
    }

    @Override
    public Builder<T> subject(SubjectRef subject) {
      this.subject = subject;
      return this;
    }

    @Override
    public Builder<T> resourceType(ObjectRefFactory<T> resourceType) {
      this.resourceType = resourceType;
      return this;
    }

    @Override
    public LookupResources<T> build() {
      if (permission == null || subject == null || resourceType == null) {
        throw new IllegalStateException("Permission, subject, and resourceType must be set");
      }
      return new LookupResourcesImpl<>(this);
    }
  }
}
