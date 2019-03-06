package com.googlecode.hotire.base.utils;

import java.util.Iterator;
import java.util.List;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Profiles;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

public class NotProductionProfileCondition implements Condition {

  @Override
  public boolean matches(ConditionContext conditionContext,
    AnnotatedTypeMetadata annotatedTypeMetadata) {

    MultiValueMap<String, Object> attrs = annotatedTypeMetadata.getAllAnnotationAttributes(NotProfile.class.getName());

    if (attrs != null) {
      Iterator var4 = ((List)attrs.get("value")).iterator();

      Object value;
      do {
        if (!var4.hasNext()) {
          return false;
        }

        value = var4.next();
      } while(!conditionContext.getEnvironment().acceptsProfiles(Profiles.of((String[])((String[])value))));

      return false;
    } else {
      return false;
    }
  }
}
