/**
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. 
 * If a copy of the MPL was not distributed with this file, You can obtain one at 
 * http://mozilla.org/MPL/2.0/.
 * 
 * This Source Code Form is also subject to the terms of the Health-Related Additional
 * Disclaimer of Warranty and Limitation of Liability available at
 * http://www.carewebframework.org/licensing/disclaimer.
 */
package org.carewebframework.icons.openiconlibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.carewebframework.ui.icons.IconLibraryRegistry;
import org.carewebframework.ui.icons.IIconLibrary;
import org.carewebframework.ui.test.CommonTest;

import org.junit.Test;

public class IconsTest extends CommonTest {
    
    @Test
    public void test() {
        IconLibraryRegistry reg = desktopContext.getBean("iconLibraryRegistry", IconLibraryRegistry.class);
        assertNotNull(reg);
        IIconLibrary lib = reg.get("apps");
        assertNotNull(lib);
        assertEquals("~./org/carewebframework/icons/openiconlibrary/16x16/apps/acroread.png", lib.getIconUrl("acroread.png", "16x16"));
        assertEquals("~./org/carewebframework/icons/openiconlibrary/16x16/apps/acroread.png", lib.getIconUrl("acroread.png", null));
        assertEquals(3004, lib.getMatching("*", "16x16").size());
        assertEquals(2950, lib.getMatching("*", "32x32").size());
        assertEquals(6, lib.getMatching("ab*", "16x16").size());
        assertEquals(34, lib.getMatching("ab*", "*").size());
        assertEquals(12, reg.getMatching("a*t?ons", "pr*ss*", "16x*").size());
        lib = reg.get("none");
        assertNull(lib);
    }
}
