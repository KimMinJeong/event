import { axiosPost } from './config'

/**
 * @param {string} userName
 * @param {string} phoneNo
 * @param {string} email
 * @param {string} seminarYn
 * 
 */
export const user_register = ( userName, phoneNo, email, seminarYn ) => {
    axiosPost('user_register', { userName, phoneNo, email, seminarYn }).then(response => {
      if (response.result_code !== 'OK') {
        if(response.result_code === 'NO_CONTENT'){
            alert(response.result_msg);
        }
      } else {
        alert(response.result_msg);
      }
    })
  }
  