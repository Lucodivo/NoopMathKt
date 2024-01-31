# NoopMathKt
[![](https://jitpack.io/v/lucodivo/NoopMathKt.svg)](https://jitpack.io/#lucodivo/NoopMathKt)

NoopMathKt is a bare bones linear algebra Kotlin library with emphasis on integration with OpenGL.

## Specifics
NoopMathKt stores matrices column-major. So, for a Mat4, the first 4 elements make up the first
column of the matrix. For a Mat4, elements at index 0, 4, 8, and 12 make up the first row of the
matrix. Vectors are treated as column vectors. This decision is strictly to maintain the standard
conventions of mathematics and OpenGL itself.

NoopMathKt is agnostic to left-hand/right-hand. It's just a linear algebra number cruncher.
Multiply two matrices and it will do matrix multiplication. As simple as that.
## Use
### Gradle 

    dependencies {
        ...
        implementation("com.github.lucodivo:NoopMathKt:v0.2.4-alpha") // or latest
        ...
    }

### Create RotationTranslation Matrix

    val translationMat = Mat4(
        1.0f, 0.0f, 0.0f, 0.0f,
        0.0f, 1.0f, 0.0f, 0.0f,
        0.0f, 0.0f, 1.0f, 0.0f,
        -position.x, -position.y, -position.z, 1.0f)

    val rotationMat = Mat4(
        xAxis.x, yAxis.x, zAxis.x, 0.0f,
        xAxis.y, yAxis.y, zAxis.y, 0.0f,
        xAxis.z, yAxis.z, zAxis.z, 0.0f,
        0.0f, 0.0f, 0.0f, 1.0f)

    val rotationThenTranslationMat = rotationMat * translationMat

### Uniform Helper Functions


    fun setUniform(name: String, value: Vec2) = glUniform2fv(glGetUniformLocation(id, name), 1, value.elements, 0)
    fun setUniform(name: String, value: Vec3) = glUniform3fv(glGetUniformLocation(id, name), 1, value.elements, 0)
    fun setUniform(name: String, value: Vec4) = glUniform4fv(glGetUniformLocation(id, name), 1, value.elements, 0)

    fun setUniform(name: String, value: Mat2) = glUniformMatrix2fv(glGetUniformLocation(id, name), 1, false, value.elements, 0)
    fun setUniform(name: String, value: Mat3) = glUniformMatrix3fv(glGetUniformLocation(id, name), 1, false, value.elements, 0)
    fun setUniform(name: String, value: Mat4) = glUniformMatrix4fv(glGetUniformLocation(id, name), 1, false, value.elements, 0)
