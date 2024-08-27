import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CatImageModel(
    @Json(name = "id") val id: Int,
    @Json(name = "url") val url: String
)