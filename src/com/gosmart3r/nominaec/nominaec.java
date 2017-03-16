package com.gosmart3r.nominaec;
import com.unit4.karat.base.OTException;
import com.unit4.karat.bo.BOEnvironment;
import com.unit4.karat.bo.BOObject;
import com.unit4.karat.da.DAConnection;
import com.unit4.karat.da.DAConnectionSource;
import com.unit4.karat.da.DAException;
import com.unit4.karat.da.DAResultSet;
import com.unit4.karat.form.FMContainer;
import com.unit4.karat.form.FMDefaultEvents;
import com.unit4.karat.form.FMEvent;
import com.unit4.karat.form.FMObject;
import com.unit4.karat.session.Session;


public class nominaec extends FMDefaultEvents{

	private String sEmpresa;
	private String sEntorno;
	private String sOrganizacion;
	
	
	
	/**
	 * @return the sEmpresa
	 */
	public String getsEmpresa() {
		return sEmpresa;
	}



	/**
	 * @return the sEntorno
	 */
	public String getsEntorno() {
		return sEntorno;
	}



	/**
	 * @return the sOrganizacion
	 */
	public String getsOrganizacion() {
		return sOrganizacion;
	}



	public nominaec(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	public void formLoad(FMEvent paramFMEvent)
		    throws OTException
		  {
		    super.formLoad(paramFMEvent);
		    BOEnvironment localBOEnvironment = this.fmObject.getBOObject().getEnvironment();
		    FMContainer localFMContainer = this.fmObject.getContainer(this.fmObject.getName());
		    
		    Boolean bRetorno=false;
			String sUsuario = session.getUserInfo().getUserName();
			
			try {
				String sEntorno= session.getEnvironmentVariable("gp_env_gestionpersonal", "env_entorno",sUsuario);
				String sEmpresa = session.getEnvironmentVariable("gp_env_gestionpersonal", "env_empresa",sUsuario);
				String sOrganizacion = session.getEnvironmentVariable("gp_env_gestionpersonal", "env_organizacion",sUsuario);
				
				if(sEntorno.length()>0 && sEmpresa.length()>0 && sOrganizacion.length()>0 ){
					bRetorno=true;
				}else{
					fmObject.showMessageText("Debe selecionar una Empresa, Entorno y Organización activos para continuar", "Aceptar/Cancelar");
					bRetorno=false;
				}
				
				
			} catch (OTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		  }
	

}
