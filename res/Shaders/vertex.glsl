#version 400 core
layout (location = 0) in vec3 aPos;

out vec2 pos;

uniform mat4 transform;

void main()
{
    gl_Position = vec4(aPos, 1.0);
	pos = vec2(aPos);
}