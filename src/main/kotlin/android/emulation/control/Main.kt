package android.emulation.control

import com.squareup.wire.GrpcClient
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.Protocol
import java.io.ByteArrayInputStream
import java.io.File
import java.io.FileOutputStream

fun main() = runBlocking {
    val client = createGrpcClient()
    val service = client.create(EmulatorControllerClient::class)
    val request = ImageFormat(format = ImageFormat.ImgFormat.RAW)
    runCatching { service.getScreenshot().execute(request) }
        .onSuccess { saveImage(it) }
        .onFailure { println(it.message) }
    Unit
}

fun createGrpcClient() =
    GrpcClient.Builder()
        .client(OkHttpClient.Builder().protocols(listOf(Protocol.H2_PRIOR_KNOWLEDGE)).build())
        .baseUrl("http://localhost:5556")
        .build()

fun saveImage(image: Image) {
    val file = File(System.getProperty("user.home"), "screenshot.png")
    val outputStream = FileOutputStream(file)
    val inputStream = ByteArrayInputStream(requireNotNull(image.image).toByteArray())
    inputStream.copyTo(outputStream)
    outputStream.close()
    inputStream.close()
}