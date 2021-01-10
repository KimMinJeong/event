import axios from 'axios'
import qs from 'qs'

const host = 'http://localhost:8090/'
const instance = axios.create({
  baseURL: `${host}`,
  headers: {
    // Accept: 'application/text; charset=utf8'
    // 'Content-Type': 'application/text; charset=utf8'
  }
})

/**
 * 결과 처리를 페이지에서 하는 경우
 * @param {String} cmd
 * @param {Object} data
 */
export const axiosPost = (cmd, data) => {
  return instance({
    method: 'post',
    url: 'api.do',
    data: qs.stringify(Object.assign(data, { cmd }))
  })
    .then(_response => {
      if (_response.data) {
        if (_response.data.result_code !== 'OK' && !_response.data.result_msg) {
          throw new Error(_response.data.result_code)
        }
        return _response.data
      } else throw new Error('response data is null')
    })
    .catch(error => {
      console.error(error)
    })
}
