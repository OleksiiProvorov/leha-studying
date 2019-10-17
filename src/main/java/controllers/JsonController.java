package controllers;

import JsonApp.NamesRepository;
import JsonApp.UsersRepository;
import JsonApp.JsonName;
import JsonApp.JsonUser;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Path("/jsonNames")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class JsonController {
    private File file1 = new File("txt1.json");
    private File file2 = new File("txt2.json");
    private ObjectMapper objectMapper;
    private NamesRepository namesRepository;
    private UsersRepository usersRepository;


    public JsonController(ObjectMapper objectMapper, NamesRepository namesRepository, UsersRepository usersRepository) {
        this.objectMapper = objectMapper;
        this.namesRepository = namesRepository;
        this.usersRepository = usersRepository;
    }

    @POST
    @Path("/names")
    public Response putName(JsonName name) {
        namesRepository.insert(name);
        List<JsonName> list = namesRepository.getAll();
        return Response.ok(list).build();
    }

    @POST
    @Path("/users")
    public Response putUser(JsonUser user) {
        usersRepository.insert(user);
        List<JsonUser> list = usersRepository.getAll();
        return Response.ok(list).build();
    }

    @POST
    @Path("/names-by-Query")
    public Response putNameByQuery(@QueryParam("name") String name) {
        namesRepository.insert(new JsonName(name));
        List<JsonName> list = namesRepository.getAll();
        return Response.ok(list).build();

    }

    @POST
    @Path("/users-by-Query")
    public Response putUserByQuery(@QueryParam("name") String name,
                                   @QueryParam("age") String age) {
        usersRepository.insert(new JsonUser(name, age));
        List<JsonUser> list = usersRepository.getAll();

        return Response.ok(list).build();
    }

    @POST
    @Path("/names-by-Path/{name}")
    public Response putNameByPath(@PathParam("name") String name) {
        namesRepository.insert(new JsonName(name));
        List<JsonName> list = namesRepository.getAll();

        return Response.ok(list).build();
    }

    @POST
    @Path("/users-by-Path/{name}/{age}")
    public Response putUserByPath(@PathParam("name") String name,
                                  @PathParam("age") String age) {
        usersRepository.insert(new JsonUser(name, age));
        List<JsonUser> list = usersRepository.getAll();

        return Response.ok(list).build();
//        try {
//            List<TestUser> list = new ArrayList<>(Arrays.asList(objectMapper.readValue(file2, TestUser[].class)));
//            TestUser newValue = new TestUser(name, age);
//
//            list.add(newValue);
//
//            String content = objectMapper.writeValueAsString(list);
//
//            writeToFile(content, file2);
//
//            return Response.ok(list).build();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @GET
    @Path("/show-names")
    public Response showNames() {
        List<JsonName> list = namesRepository.getAll();

        return Response.ok(list).build();
    }

    @GET
    @Path("/show-users")
    public Response showUsers() {
        List<JsonUser> list = usersRepository.getAll();
//        try {
//            List<TestUser> list = new ArrayList<>(Arrays.asList(objectMapper.readValue(file2, TestUser[].class)));
//
//            return Response.ok(list).build();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return Response.ok(list).build();
    }

    @DELETE
    @Path("/delete-names")
    public Response deleteNames() {
        namesRepository.delete();
        return Response.ok("users are deleted").build();
    }

    @DELETE
    @Path("/delete-users")
    public Response deleteUsers() {
        usersRepository.delete();
        return Response.ok("users are deleted").build();
    }
//
//    private void writeToFile(String content1, File file) {
//        try {
//            FileWriter fileWriter = new FileWriter(file);
//            fileWriter.write(content1);
//            fileWriter.flush();
//            fileWriter.close();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

    public static class TestName {
        private String name;

        public TestName(String name) {
            this.name = name;
        }


        public TestName() {
        }

        public String getName() {
            return name;
        }
    }

    public static class TestUser {
        private String name;
        private String age;

        public TestUser(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public TestUser() {
        }

        public String getName() {
            return name;
        }

        public String getAge() {
            return age;
        }
    }

}
