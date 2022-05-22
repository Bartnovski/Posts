import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {
    val placeholder1 = Placeholder()
    val donut1 = Donut(false, 1U, placeholder1, false, "")
    val view1 = Views(1U)
    val reports = Reposts(1U, false)
    val likes1 = Likes(1U, false, false, false)
    val copyright1 = Copyright(1U, "", "", "")
    val comment1 = Comments(1U, false, false, false, false)

    @Test
    fun wallServiceAdd() {
        val service = WallService
        val result = service.add(
            Post(
                10645U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, comment1, copyright1, likes1, reports, view1,
                1U, false, false, false, false, false, false, donut1, 1U
            )
        )
        assertNotEquals(0, result.id)
    }

    @Test
    fun updateExistingTrue() {
        val service = WallService
        service.add(
            Post(
                10645U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, comment1, copyright1, likes1, reports, view1,
                1U, false, false, false, false, false, false, donut1, 1U
            )
        )
        service.add(
            Post(
                9578U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, comment1, copyright1, likes1, reports, view1,
                1U, false, false, false, false, false, false, donut1, 1U
            )
        )
        service.add(
            Post(
                4875U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, comment1, copyright1, likes1, reports, view1,
                1U, false, false, false, false, false, false, donut1, 1U
            )
        )

        val update = Post(
            4875U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, comment1, copyright1, likes1, reports, view1,
            1U, false, false, false, false, false, false, donut1, 1U
        )

        val result = service.update(update)

        assertTrue(result)
    }

    @Test
    fun updateExistingFalse() {
        val service = WallService
        service.add(
            Post(
                10645U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, comment1, copyright1, likes1, reports, view1,
                1U, false, false, false, false, false, false, donut1, 1U
            )
        )
        service.add(
            Post(
                9578U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, comment1, copyright1, likes1, reports, view1,
                1U, false, false, false, false, false, false, donut1, 1U
            )
        )
        service.add(
            Post(
                4875U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, comment1, copyright1, likes1, reports, view1,
                1U, false, false, false, false, false, false, donut1, 1U
            )
        )

        val update = Post(
            36765U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, comment1, copyright1, likes1, reports, view1,
            1U, false, false, false, false, false, false, donut1, 1U
        )

        val result = service.update(update)

        assertFalse(result)
    }
}
