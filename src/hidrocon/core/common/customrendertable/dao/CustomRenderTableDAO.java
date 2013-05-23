/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hidrocon.core.common.customrendertable.dao;


import hidrocon.core.common.customrendertable.entities.CustomRenderTable;
import hidrocon.core.generic.dao.HidroDAO;
import java.util.List;

/**
 *
 * @author david
 */
public class CustomRenderTableDAO extends HidroDAO {

	public List<CustomRenderTable> getCustomRenderTableList() {
		return entityManager.createNamedQuery("CustomRenderTable.findAll").getResultList();
	}
	
}
