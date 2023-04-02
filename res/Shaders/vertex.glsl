#version 400 core
layout (location = 0) in vec3 aPos;

out vec3 pos;

uniform mat4 transform;
uniform mat4 view;
uniform mat4 model;

void main()
{
    gl_Position = transform * vec4(aPos, 1.0);
	pos = aPos;
}