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
package org.eclipse.scout.contacts.shared.module.events.event;

import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.shared.TunnelToServer;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

@ApplicationScoped
@TunnelToServer
public interface IEventService {

  EventTablePageData getTableData(SearchFilter filter, String organizationId);

  EventFormData create(EventFormData formData);

  EventFormData load(EventFormData formData);

  EventFormData prepareCreate(EventFormData formData);

  EventFormData store(EventFormData formData);
}
