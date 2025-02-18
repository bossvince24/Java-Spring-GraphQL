## GraphQL Postman Format

## Request Type 
- POST

## API Response, URL, QUERY 

- ADD
- http://localhost:8081/graphql
- mutation {
  addUser(
    name: "John Smith", 
    email: "john.smith@example.com", 
    bio: "Software Developer", 
    profilePictureUrl: "http://example.com/john.jpg"
  ) {
    id
    name
    email
    profile {
      bio
      profilePictureUrl
    }
  }
}

## API Response, URL, QUERY 
- GET ALL
- {
  getUsers {
    id
    name
    email
  }
}

## API Response, URL, QUERY 

- GET BY ID
- {
  getUser(id: 3) {
    id
    name
    email
  }
}

## API Response, URL, QUERY 

- GET BY NAME
- {
  getUserByName(name: "John") {
    id
    name
    email
  }
}

## API Response, URL, QUERY 

- GET ALL USERS PROFILES
- {
  getUsers {
    id
    name
    email
    profile {
      bio
      profilePictureUrl
    }
  }
}

## API Response, URL, QUERY 

- GET USER PROFILE BY ID
- {
  getUser(id: 1) {
    id
    name
    email
    profile {
      bio
      profilePictureUrl
    }
  }
}

## API Response, URL, QUERY 

- GET USER BY PROFILE BIO
- query {
  getUsersByProfileBio(bio: "Software Developer") {
    id
    bio
    profilePictureUrl
    user {
      name
      email
    }
  }
}







 
