package pojo;

/**
 * Created by eit on 9/14/15.
 */
public class Official {

    private Integer id;
    private User user;

    public Official(){}

    public Official(Integer id, User user){
        this.setId(id);
        this.setUser(user);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public class User{
        /*
        *
        * "id": 28,
        "social_id": null,
        "email": "seth@gmail.com",
        "first_name": "Seth",
        "last_name": "Terkper",
        "bio": "Hon, Seth Terkper is the current Minister of Finance and Economic Planning (MOFEP)\r\nHe obtained his first degree in Bachelor of Commerce (B.Comm.) from the University of Cape Coast (UCC) in Ghana.\r\nHe is also a Chartered Accountant who holds a Master of Public Administration (MPA) degree from the Kennedy School, Harvard University.\r\nHe also served as a Deputy Minister in the Ministry of Finance and Economic Planning (MOFEP) from March 2009 to January 2013, and worked mainly on the Budget and Medium-Term Expenditure Framework (MTEF) as well as on revenue policy and administration.\r\nHe is a member of the Board of Directors of the Bank of Ghana (BOG) and chaired the joint Steering Committee of the Ghana Revenue Authority (GRA) and Ghana Integrated Financial Management Information System (GIFMIS) reforms.",
        "avatar": "http://assurances.s3.amazonaws.com/media/avatars/tekper.jpg",
        "created": "2014-07-02T13:08:38.033Z",
        "get_role": "Public Official"
        */

        private Integer id;
        private String email, first_name, last_name, bio, avatar, created, role;

        public User(){}

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}


