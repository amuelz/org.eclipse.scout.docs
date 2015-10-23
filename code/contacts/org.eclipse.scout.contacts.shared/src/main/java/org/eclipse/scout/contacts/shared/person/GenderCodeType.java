/*******************************************************************************
 * Copyright (c) 2015 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.scout.contacts.shared.person;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCode;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCodeType;

public class GenderCodeType extends AbstractCodeType<String, String> {

  private static final long serialVersionUID = 1L;
  public static final String ID = "Gender";

  public GenderCodeType() {
    super();
  }

  @Override
  protected String getConfiguredText() {
    return TEXTS.get("Gender");
  }

  @Override
  public String getId() {
    return ID;
  }

  @Order(1000.0)
  public static class MaleCode extends AbstractCode<String> {

    private static final long serialVersionUID = 1L;
    public static final String ID = "M";

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Male");
    }

    @Override
    public String getId() {
      return ID;
    }
  }

  @Order(2000.0)
  public static class FemaleCode extends AbstractCode<String> {

    private static final long serialVersionUID = 1L;
    public static final String ID = "F";

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Female");
    }

    @Override
    public String getId() {
      return ID;
    }
  }
}
