package ReNAQH.Components.Renderer;

import ReNAQH.Core.Component;
import ReNAQH.Renderer.Mesh;

public class MeshRenderer extends Component {
	MeshFilter meshFilter;
	Mesh mesh;
	
	public void Start() {
		meshFilter = GameObject().GetComponent(MeshFilter.class);
		
		if(meshFilter != null) {
			mesh = meshFilter.mesh;
		}
	}
}