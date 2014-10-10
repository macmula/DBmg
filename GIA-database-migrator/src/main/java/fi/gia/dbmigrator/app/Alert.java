package fi.gia.dbmigrator.app;

import java.sql.Wrapper;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class Alert {
	
	
		
		
	
		private int pasID;		
		private String status;
		private boolean shared;
		private String header;
		private String desc;
		
		
		
		
		public int getPasID() {
			return pasID;
		}

		public void setPasID(int pasID) {
			this.pasID = pasID;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		public boolean isShared() {
			return shared;
		}

		public void setShared(boolean shared) {
			this.shared = shared;
		}

		public String getHeader() {
			return header;
		}
		public void setHeader(String header) {
			this.header = header;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		
		@Override
		public String toString() {
			
			 StringBuilder sb = new StringBuilder();
		        sb.append("***** Alert Details *****\n");
		        sb.append("PasID="+getPasID()+"\n");
		        sb.append("Status="+getStatus()+"\n");
		        sb.append("Shared="+isShared()+"\n");
		        sb.append("Header="+getHeader()+"\n");
		        sb.append("Description="+getDesc()+"\n");		        
		        sb.append("*****************************");
		         
		        return sb.toString();
			
			
		}
		
		
		
		
}


