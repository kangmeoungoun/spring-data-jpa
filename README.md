![image](https://user-images.githubusercontent.com/40969203/102683364-d75de980-4213-11eb-8983-7a138f2238fa.png)
![image](https://user-images.githubusercontent.com/40969203/102683370-e0e75180-4213-11eb-9e61-ded1024086ed.png)

Post post = new Post();
post.setTitle("jpa");
Post savePost =postRepository.save(post);//insert persist

id 값을 넘기지 않으면 transient ->persistent 상태 
post ==savePost 가 같고 Persistent 상태

Post postUpdate = new Post();
postUpdate.setId(post.getId());
postUpdate.setTitle("hibernate");
Post updatePost = postRepository.save(postUpdate);//update merge

id값을 주면 merge 상태 에서 postUpdate 는 Persistent 상태가 아니고
updatePost 만 Persistent 상태