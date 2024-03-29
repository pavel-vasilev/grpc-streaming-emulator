// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: emulator_controller.proto
package android.emulation.control

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
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
import okio.ByteString

class Image(
  @field:WireField(
    tag = 1,
    adapter = "android.emulation.control.ImageFormat#ADAPTER"
  )
  val format: ImageFormat? = null,
  @field:WireField(
    tag = 2,
    adapter = "com.squareup.wire.ProtoAdapter#UINT32"
  )
  val width: Int? = null,
  @field:WireField(
    tag = 3,
    adapter = "com.squareup.wire.ProtoAdapter#UINT32"
  )
  val height: Int? = null,
  @field:WireField(
    tag = 4,
    adapter = "com.squareup.wire.ProtoAdapter#BYTES"
  )
  val image: ByteString? = null,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<Image, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is Image) return false
    return unknownFields == other.unknownFields
        && format == other.format
        && width == other.width
        && height == other.height
        && image == other.image
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + format.hashCode()
      result = result * 37 + width.hashCode()
      result = result * 37 + height.hashCode()
      result = result * 37 + image.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (format != null) result += """format=$format"""
    if (width != null) result += """width=$width"""
    if (height != null) result += """height=$height"""
    if (image != null) result += """image=$image"""
    return result.joinToString(prefix = "Image{", separator = ", ", postfix = "}")
  }

  fun copy(
    format: ImageFormat? = this.format,
    width: Int? = this.width,
    height: Int? = this.height,
    image: ByteString? = this.image,
    unknownFields: ByteString = this.unknownFields
  ): Image = Image(format, width, height, image, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<Image> = object : ProtoAdapter<Image>(
      FieldEncoding.LENGTH_DELIMITED, 
      Image::class
    ) {
      override fun encodedSize(value: Image): Int = 
        ImageFormat.ADAPTER.encodedSizeWithTag(1, value.format) +
        ProtoAdapter.UINT32.encodedSizeWithTag(2, value.width) +
        ProtoAdapter.UINT32.encodedSizeWithTag(3, value.height) +
        ProtoAdapter.BYTES.encodedSizeWithTag(4, value.image) +
        value.unknownFields.size

      override fun encode(writer: ProtoWriter, value: Image) {
        ImageFormat.ADAPTER.encodeWithTag(writer, 1, value.format)
        ProtoAdapter.UINT32.encodeWithTag(writer, 2, value.width)
        ProtoAdapter.UINT32.encodeWithTag(writer, 3, value.height)
        ProtoAdapter.BYTES.encodeWithTag(writer, 4, value.image)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): Image {
        var format: ImageFormat? = null
        var width: Int? = null
        var height: Int? = null
        var image: ByteString? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> format = ImageFormat.ADAPTER.decode(reader)
            2 -> width = ProtoAdapter.UINT32.decode(reader)
            3 -> height = ProtoAdapter.UINT32.decode(reader)
            4 -> image = ProtoAdapter.BYTES.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return Image(
          format = format,
          width = width,
          height = height,
          image = image,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: Image): Image = value.copy(
        format = value.format?.let(ImageFormat.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }
  }
}
