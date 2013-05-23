/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.core.common.customrendertable.manager;

import hidrocon.core.common.customrendertable.bc.CustomRenderTableBC;
import hidrocon.core.common.customrendertable.entities.CustomRenderTable;
import java.util.List;

/**
 *
 * @author david
 */
public class CustomRenderTableManager {

	public List<CustomRenderTable> getCustomRenderTableList() {
		CustomRenderTableBC bc = new CustomRenderTableBC();
		List<CustomRenderTable> list = bc.getCustomRenderTableList();
		return list;
	}

}
