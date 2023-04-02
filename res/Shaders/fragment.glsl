#version 400 core

in vec3 pos;

uniform sampler2D texture1;

void main()
{
    //gl_FragColor = texture(texture1, vec2(pos)) * vec4(sin(oTime)-pos.x, cos(oTime)-pos.y, 0.5, 0.1);
    gl_FragColor = texture(texture1, vec2(pos));
	//gl_FragColor = vec4(col, 1.0);
}