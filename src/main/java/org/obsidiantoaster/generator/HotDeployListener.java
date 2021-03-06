/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.obsidiantoaster.generator;

import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.forge.addon.manager.watch.AddonWatchService;
import org.obsidiantoaster.generator.event.FurnaceStartup;

/**
 *
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 */
public class HotDeployListener
{
   private final static Logger log = Logger.getLogger(HotDeployListener.class.getName());

   @Inject
   AddonWatchService addonWatchService;

   void init(@Observes FurnaceStartup startup)
   {
      if (Boolean.getBoolean("devMode"))
      {
         addonWatchService.start();
         addonWatchService.getMonitoredAddons().forEach(addonId -> log.info("Monitoring " + addonId));
      }
   }
}
