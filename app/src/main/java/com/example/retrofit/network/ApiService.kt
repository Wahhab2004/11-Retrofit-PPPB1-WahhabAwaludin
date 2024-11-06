import com.example.retrofit.model.Data
import com.example.retrofit.model.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface  ApiService {
    @GET("users")
    fun getUsers(@Query("page") page: Int): Call<Users>
}
