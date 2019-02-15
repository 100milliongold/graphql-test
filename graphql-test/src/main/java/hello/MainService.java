package hello;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

@Service
public class MainService {

	private final UserRepository userRepository;

	public MainService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GraphQLQuery(name = "users")
	public List<User> getUsers(
			@GraphQLArgument(name = "page") Integer page,
			@GraphQLArgument(name = "size") Integer size
			) {
		return userRepository.findAll(PageRequest.of(page, size, Sort.by("id"))).getContent();
	}

	@GraphQLQuery(name = "user")
	public Optional<User> getUserById(@GraphQLArgument(name = "id") Integer id) {
        return userRepository.findById(id);
    }

	@GraphQLMutation(name = "saveUser")
	public User saveUser(@GraphQLArgument(name = "user") User user) {
		return userRepository.save(user);
	}

	@GraphQLMutation(name = "deleteUser")
	public void deleteUser(@GraphQLArgument(name = "id") Integer id) {
		userRepository.deleteById(id);
	}

}
