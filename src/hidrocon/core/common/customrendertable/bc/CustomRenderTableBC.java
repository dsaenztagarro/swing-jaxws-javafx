/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.core.common.customrendertable.bc;

import hidrocon.core.common.customrendertable.dao.CustomRenderTableDAO;
import hidrocon.core.common.customrendertable.entities.CustomRenderTable;
import java.util.List;

/**
 *
 * @author david
 */
public class CustomRenderTableBC {

	public List<CustomRenderTable> getCustomRenderTableList() {
		CustomRenderTableDAO dao = new CustomRenderTableDAO();
		List list = dao.getCustomRenderTableList();
		return list;
	}

}
