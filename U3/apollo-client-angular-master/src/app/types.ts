export type User = {
    id: number;
    email: string;
    first_name: string;
    last_name: string;
    user_id: string;
    email_verification_status: string;
    emailverification_token: string;
    encrypted_password: string;
}

export type Query = {
    allUsers: User[];
}
