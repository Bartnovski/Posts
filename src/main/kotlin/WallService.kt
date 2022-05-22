object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post) : Post {
        posts += post
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for(search in posts) {
            if(search.id == post.id) {
                val index = posts.indexOf(search)
                posts[index] = post.copy(ownerId = search.ownerId, date = search.date)
                return true
            }
        }
        return false
    }
}
