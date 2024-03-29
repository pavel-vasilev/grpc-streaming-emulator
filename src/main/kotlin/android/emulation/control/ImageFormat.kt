// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: emulator_controller.proto
package android.emulation.control

import com.squareup.wire.EnumAdapter
import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.WireEnum
import com.squareup.wire.WireField
import kotlin.Any
import kotlin.AssertionError
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.Nothing
import kotlin.String
import kotlin.hashCode
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import okio.ByteString

class ImageFormat(
  @field:WireField(
    tag = 1,
    adapter = "android.emulation.control.ImageFormat${'$'}ImgFormat#ADAPTER"
  )
  val format: ImgFormat? = null,
  @field:WireField(
    tag = 2,
    adapter = "android.emulation.control.Rotation#ADAPTER"
  )
  val rotation: Rotation? = null,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<ImageFormat, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is ImageFormat) return false
    return unknownFields == other.unknownFields
        && format == other.format
        && rotation == other.rotation
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + format.hashCode()
      result = result * 37 + rotation.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (format != null) result += """format=$format"""
    if (rotation != null) result += """rotation=$rotation"""
    return result.joinToString(prefix = "ImageFormat{", separator = ", ", postfix = "}")
  }

  fun copy(
    format: ImgFormat? = this.format,
    rotation: Rotation? = this.rotation,
    unknownFields: ByteString = this.unknownFields
  ): ImageFormat = ImageFormat(format, rotation, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<ImageFormat> = object : ProtoAdapter<ImageFormat>(
      FieldEncoding.LENGTH_DELIMITED, 
      ImageFormat::class
    ) {
      override fun encodedSize(value: ImageFormat): Int = 
        ImgFormat.ADAPTER.encodedSizeWithTag(1, value.format) +
        Rotation.ADAPTER.encodedSizeWithTag(2, value.rotation) +
        value.unknownFields.size

      override fun encode(writer: ProtoWriter, value: ImageFormat) {
        ImgFormat.ADAPTER.encodeWithTag(writer, 1, value.format)
        Rotation.ADAPTER.encodeWithTag(writer, 2, value.rotation)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): ImageFormat {
        var format: ImgFormat? = null
        var rotation: Rotation? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> try {
              format = ImgFormat.ADAPTER.decode(reader)
            } catch (e: ProtoAdapter.EnumConstantNotFoundException) {
              reader.addUnknownField(tag, FieldEncoding.VARINT, e.value.toLong())
            }
            2 -> rotation = Rotation.ADAPTER.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return ImageFormat(
          format = format,
          rotation = rotation,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: ImageFormat): ImageFormat = value.copy(
        rotation = value.rotation?.let(Rotation.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }
  }

  enum class ImgFormat(
    override val value: Int
  ) : WireEnum {
    PNG(0),

    RAW(1),

    RGB888(2),

    RGBA8888(3);

    companion object {
      @JvmField
      val ADAPTER: ProtoAdapter<ImgFormat> = object : EnumAdapter<ImgFormat>(
        ImgFormat::class
      ) {
        override fun fromValue(value: Int): ImgFormat? = ImgFormat.fromValue(value)
      }

      @JvmStatic
      fun fromValue(value: Int): ImgFormat? = when (value) {
        0 -> PNG
        1 -> RAW
        2 -> RGB888
        3 -> RGBA8888
        else -> null
      }
    }
  }
}
